#provider variable

variable "aws_region" {
  type = string
  default = "us-east-2"
}

variable "aws_profile" {
  type = string
  default = "default"
}

variable "ec2_instance" {
  type = string
  default = "t2.micro"
}
variable "ec2_ami" {
  type = string
  default = "ami-0d97ef13c06b05a19"
}
# Environment var
variable "env" {
  type        = string
  default     = "dev"
  description = "Environment"
}

# Instance ssh key name
variable "ssh_key_name" {
  type        = string
  default     = "idris_id_rsa.pub"
  description = "Instance ssh key name"
}

variable "instance_count" {
  type      = number
  default   = 1
  description = "Instance number"
}

