# Use the official MariaDB image from Docker Hub
FROM mariadb:latest

# Set environment variables for the MariaDB root user
ENV MARIADB_ROOT_PASSWORD=rootpassword
ENV MARIADB_DATABASE=mydatabase

# Copy the SQL script to Docker entrypoint directory
COPY init.sql /docker-entrypoint-initdb.d/

# Expose the default MariaDB port
EXPOSE 3306

