variable "aws_region" {
  type    = string
  default = "us-east-1"
}


variable "app_name" {
  type    = string
  default = "velammal-app"
}


variable "artifact_bucket" {
  type        = string
  description = "S3 bucket name for build artifacts (must be globally unique)"
}


# You can set platform_arn to a specific Elastic Beanstalk platform ARN for Tomcat 10 + Java 21
variable "platform_arn" {
  type        = string
  description = "Optional: EB platform ARN (recommended to specify exact platform for your region)."
  default     = "arn:aws:elasticbeanstalk:us-east-1::platform/Tomcat 11 with Corretto 25 running on 64bit Amazon Linux 2023/5.9.0"
}