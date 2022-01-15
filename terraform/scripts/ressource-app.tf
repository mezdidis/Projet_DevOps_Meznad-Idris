resource "aws_instance" "app_instance" {
  count                  = var.instance_count
  ami                    = var.ec2_ami
  key_name = var.ssh_key_name
  instance_type          = var.ec2_instance
  vpc_security_group_ids = [aws_security_group.idris.id]
  associate_public_ip_address = "true"
  user_data                   = data.template_file.user_data.rendered


  tags                        = {
    Name        = "${var.env}-MEZNAD-Idris-${count.index}"
    Environment = var.env
    Groups      = "app"
    Owner       = "idris.meznad@ynov.com"
  }
}

resource "aws_key_pair" "deployer" {

  tags                        = {
    Name = "Meznad Idris"
  }
  key_name               = var.ssh_key_name
  public_key             = file("/home/mezdidis/.ssh/id_rsa.pub")
}

data "template_file" "user_data" {
  template = file("scripts/add-ssh-web-app.yaml")
}
