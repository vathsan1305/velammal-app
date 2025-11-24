output "s3_bucket" {
  value = aws_s3_bucket.artifact.bucket
}

output "gha_access_key_id" {
  value = aws_iam_access_key.gha_key.id
}

output "gha_secret_access_key" {
  value     = aws_iam_access_key.gha_key.secret
  sensitive = true
}

output "elasticbeanstalk_url" {
  value = aws_elastic_beanstalk_environment.env.endpoint_url
}
