FROM node:18
WORKDIR /usr/src/app
COPY package*.json ./
RUN npm install
COPY server.js ./
RUN npm install express pg-promise
CMD ["npm", "start"]