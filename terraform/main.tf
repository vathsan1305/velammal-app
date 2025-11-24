terraform {
  required_version = ">= 1.1"
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = ">= 4.0"
    }
  }
}

provider "aws" {
  region = var.aws_region
}

# S3 bucket for artifacts
resource "aws_s3_bucket" "artifact" {
  bucket        = var.artifact_bucket
  force_destroy = true

  tags = {
    Name = "${var.app_name}-artifacts"
  }
}
