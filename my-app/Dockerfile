# Use the official Node.js 14 LTS image as the base image
FROM node:18.4.0-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the package.json and package-lock.json files to the working directory
COPY package*.json ./

# Install project dependencies
RUN npm install

# Copy the entire project directory to the working directory
COPY . .

# Build the Nuxt.js project
RUN npm run build

# Set the environment variable for the production mode
ENV NODE_ENV production

# Expose the default Nuxt.js port (3000)
EXPOSE 3000

# Start the Nuxt.js server
CMD ["npm", "start"]

