output "public_ip" {
  description = "List of private IP addresses assigned to the instances"
  value       = aws_instance.app_instance.*.public_ip
}

output userdata {
  value = "\n${data.template_file.user_data.rendered}"
}

output "instance_id" {
  description = "ID of the EC2 instance"
  value       = aws_instance.app_instance.*.id
}