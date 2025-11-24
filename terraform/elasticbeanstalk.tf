# Elastic Beanstalk application
resource "aws_elastic_beanstalk_application" "app" {
  name        = var.app_name
  description = "Velammal School App (Tomcat 11 / Corretto 25)"
}

# Elastic Beanstalk environment
resource "aws_elastic_beanstalk_environment" "env" {
  name        = "Velammal-app-env"
  application = aws_elastic_beanstalk_application.app.name

  # Correct way to set the platform
  # (This MUST be the ARNs returned from AWS)
  platform_arn = var.platform_arn

  # Instance profile to allow EC2 access
  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name      = "IamInstanceProfile"
    value     = aws_iam_instance_profile.eb_instance_profile.arn
  }

  # EB service role
  setting {
    namespace = "aws:elasticbeanstalk:environment"
    name      = "ServiceRole"
    value     = aws_iam_role.eb_service_role.arn
  }

  # Example environment variable
  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "APP_ENV"
    value     = "production"
  }

  # Prevent unnecessary destroy/create
  wait_for_ready_timeout = "20m"
}
