#!/bin/bash

# Exit immediately if a command exits with a non-zero status
set -e

# Variables for database setup
DB_ROOT_PASSWORD="root_password"  # Change this to a secure password for the root user
DB_NAME="badapp_db"
DB_USER="badapp_user"
DB_PASSWORD="badapp_password"

echo "============================================"
echo "Setting up MySQL database for the application"
echo "============================================"

# Install MySQL server if not already installed
echo "Installing MySQL server..."
if ! command -v mysql >/dev/null 2>&1; then
    sudo apt update
    sudo apt install -y mysql-server
else
    echo "MySQL is already installed!"
fi

# Start the MySQL service
echo "Starting MySQL service..."
sudo systemctl start mysql
sudo systemctl enable mysql

# Secure MySQL installation (non-interactive)
echo "Securing MySQL installation..."
sudo mysql_secure_installation <<EOF

y
$DB_ROOT_PASSWORD
$DB_ROOT_PASSWORD
y
y
y
y
EOF

# Create the database, user, and tables
echo "Configuring the database..."
mysql -u root -p"$DB_ROOT_PASSWORD" <<EOF
-- Create the application database
CREATE DATABASE IF NOT EXISTS $DB_NAME;

-- Create the application user and grant privileges
CREATE USER IF NOT EXISTS '$DB_USER'@'localhost' IDENTIFIED BY '$DB_PASSWORD';
GRANT ALL PRIVILEGES ON $DB_NAME.* TO '$DB_USER'@'localhost';
FLUSH PRIVILEGES;

-- Switch to the application database
USE $DB_NAME;

-- Create the required tables
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    log_message TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

EOF

echo "============================================"
echo "MySQL setup and configuration completed!"
echo "============================================"
echo "Database Name: $DB_NAME"
echo "Username: $DB_USER"
echo "Password: $DB_PASSWORD"
echo "============================================"

# Reminder to verify connection
echo "You can test the connection using the following command:"
echo "mysql -u $DB_USER -p -h localhost $DB_NAME"

