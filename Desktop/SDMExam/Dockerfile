# FROM node 
# WORKDIR /src
# COPY . .
# EXPOSE 7002
# CMD node server.js

FROM node:14

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .

EXPOSE 7002

CMD ["node", "server.js"]