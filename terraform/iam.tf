# --------------------------
# Elastic Beanstalk Service Role
# --------------------------
resource "aws_iam_role" "eb_service_role" {
  name               = "aws-elasticbeanstalk-service-role"
  assume_role_policy = data.aws_iam_policy_document.eb_service_assume.json
}

data "aws_iam_policy_document" "eb_service_assume" {
  statement {
    actions = ["sts:AssumeRole"]
    principals {
      type        = "Service"
      identifiers = ["elasticbeanstalk.amazonaws.com"]
    }
  }
}

# VALID AWS policies for EB service role (2023+)
resource "aws_iam_role_policy_attachment" "eb_service_attach1" {
  role       = aws_iam_role.eb_service_role.name
  policy_arn = "arn:aws:iam::aws:policy/AWSElasticBeanstalkManagedUpdatesCustomerRolePolicy"
}

resource "aws_iam_role_policy_attachment" "eb_service_attach2" {
  role       = aws_iam_role.eb_service_role.name
  policy_arn = "arn:aws:iam::aws:policy/AWSElasticBeanstalkWebTier"
}

# --------------------------
# Elastic Beanstalk EC2 Role
# --------------------------
resource "aws_iam_role" "eb_ec2_role" {
  name               = "aws-elasticbeanstalk-ec2-role"
  assume_role_policy = data.aws_iam_policy_document.eb_ec2_assume.json
}

data "aws_iam_policy_document" "eb_ec2_assume" {
  statement {
    actions = ["sts:AssumeRole"]
    principals {
      type        = "Service"
      identifiers = ["ec2.amazonaws.com"]
    }
  }
}

# Correct & supported EB policies for EC2 instances
resource "aws_iam_role_policy_attachment" "eb_ec2_attach_webtier" {
  role       = aws_iam_role.eb_ec2_role.name
  policy_arn = "arn:aws:iam::aws:policy/AWSElasticBeanstalkWebTier"
}

resource "aws_iam_role_policy_attachment" "eb_ec2_attach_worker" {
  role       = aws_iam_role.eb_ec2_role.name
  policy_arn = "arn:aws:iam::aws:policy/AWSElasticBeanstalkWorkerTier"
}

resource "aws_iam_role_policy_attachment" "eb_ec2_attach_s3" {
  role       = aws_iam_role.eb_ec2_role.name
  policy_arn = "arn:aws:iam::aws:policy/AmazonS3ReadOnlyAccess"
}

resource "aws_iam_instance_profile" "eb_instance_profile" {
  name = "aws-elasticbeanstalk-ec2-role"
  role = aws_iam_role.eb_ec2_role.name
}

# --------------------------
# GitHub Actions Deployment IAM User
# --------------------------
resource "aws_iam_user" "gha_user" {
  name = "gha-velammal-deploy"
}

resource "aws_iam_user_policy_attachment" "gha_attach_s3" {
  user       = aws_iam_user.gha_user.name
  policy_arn = "arn:aws:iam::aws:policy/AmazonS3FullAccess"
}

resource "aws_iam_user_policy_attachment" "gha_attach_eb" {
  user       = aws_iam_user.gha_user.name
  policy_arn = "arn:aws:iam::aws:policy/AWSElasticBeanstalkManagedUpdatesCustomerRolePolicy"
}

# Programmatic Access Key for GitHub Actions
resource "aws_iam_access_key" "gha_key" {
  user = aws_iam_user.gha_user.name
}
