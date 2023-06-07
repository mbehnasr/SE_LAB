# SE_LAB - آزمایش های درس نرم افزار دانشگاه شریف

*mohammad mahdi behnasr - 97105793*

*reza dolati - 97110411*


## Microservice

<div dir="rtl">
ما در این آزمایش ابتدا به سراغ



 [یک پروژه open source](https://github.com/statichunt/geeky-nextjs?ref=statichunt.com) که یک تملپت نوشته شده با next js  و andt هست می رویم
 حال داکرفایل  پروژه مورد نظر را در همان دایرکتوری مینویسیم 
(داکر در سیستم نصب است )

‍‍‍‍‍‍
```
# Use the official Node.js 14 LTS image as the base image
FROM node:14

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
```


این خط به Docker اعلام می‌کند که از نسخهLTS رسمی Node.js نسخه 14 LTS به عنوان imgae  پایه برای ایجاد کانتینر 
استفاده کند.
فولدر  app را میسازد و به داخل آن میرود 

حال هر فایلی که با پکیچ شروع میشود و با جیسون خاتمه پیدا میکند را از محیط داکرفایل میگیرد و به داخل کانتیر فولدر اپ کپی میکند  
سپس 
پکیج های مورد نظر را دانلود میکند حال تمام کد پروژه را با دستوری COPY . .  کپی میکنیم 
حال پورت ۳۰۰۰ را باز میزاریم که پورت دیفالت پروژه های next js میباشد 


(البته استفاده از نسخه ۱۴ نود به مشکل خوردیم و پس از بررسی با تغییر node:14 به node:18.4.0-alpine برطرف شد )

حال  در این بین در دانلود ایمیج ها به دلیل تحریم مشکلات فراوانی خوردیم 

حال











![1](./imgs/Screenshot%20from%202023-06-05%2022-47-04.png)
![2](./imgs/Screenshot%20from%202023-06-05%2023-13-17.png)
![3](./imgs/Screenshot%20from%202023-06-06%2000-51-26.png)

حال 
با دستور docker build -t my-nextjs-app ایمیج مورد نظر ساخته شد که 
با دستور docker image ls ایمیج های موجود رد سرور را مشاهده میکنیم 


![4](./imgs/Screenshot%20from%202023-06-06%2023-07-05.png)
حال میخواهیم با ایمیچ مورد نظر یک کانتینر بیاریم بالا که پورت ۳۰۰۰ کانتیر را که expose کرده بودیم به پورت ۳۰۰۰ سرور مپ کنیم و خروجی آن را ببینیم 


![5](./imgs/Screenshot%20from%202023-06-06%2023-39-00.png)

با دستور docker container ls  کانتینر های موجود را مشاهده میکنیم که معادل دستور قدیمی و دپریکیت شده dokcer ps است 

![6](./imgs/Screenshot%20from%202023-06-06%2023-41-18.png)
![7](./imgs/Screenshot%20from%202023-06-06%2023-45-00.png)

حال پروژه مورد نظر را در مرورگر مشاهده میکنیم 


![8](./imgs/Screenshot%20from%202023-06-06%2023-45-55.png)


حال برای اینکه با مفهوم میکروسرویس بیشتر آشنا شویم و ملموس تر باشه این مفهوم 
میایم یک کانتیر دیگر برای nginx میاوریم بالا


حال برای اینکه این nginx با nextjs همگام و بتوانن با هم کار کنن  میایم یک داکرکامپوز به صورت زیر مینویسیم 

```
version: '3'
services:
  next-app:
    build:
      context: .
      dockerfile: Dockerfile
    restart: always
    environment:
      - NODE_ENV=production
    expose:
      - 3000
  nginx:
    image: nginx:latest
    ports:
      - 80:80
    volumes:
      - ./nginx/nginx.conf:/etc/nginx/nginx.conf
    depends_on:
      - next-app
```
که شامل دو سرویس next-app و nginx
میباشد
build تنظیمات ساخت کانتینر را تعیین می‌کند. context: . به معنی استفاده از دایرکتوری فعلی به عنوان مسیر ساخت و dockerfile: Dockerfile نشان می‌دهد که از فایل Dockerfile در همان دایرکتوری استفاده میکند.
restart: always تعیین می‌کند که در صورت خطا یا توقف، کانتینر به صورت خودکار راه‌اندازی شود.
که این کامند را نیز در وقتی کانتیر را با داکر ران ایجاد میکنیم نیز معادلش هست
environment تنظیمات مربوط به متغیرهای محیطی کانتینر را تعریف می‌کند. در این مورد، NODE_ENV را به production تنظیم می‌کند.
expose پورت 3000 را از داخل کانتینر به بیرون کانتینر (برای دیگر کانتینرها یا شبکه‌های برخورد) نشان می‌دهد.

<div dir="rtl">
image: nginx:latest از تصویر nginx:latest برای ایجاد کانتینر استفاده می‌کند.

پورت نیز مشخص کردیم
</div>

حال nginc.conf خود را نیز که به صورت زیر است به nginx.conf کانتیر مپ میکنیم که (همچنین  میتوانستیم تنطیمات انجنیکس را دایرکتوری حال نوشت و به فایل مخصوص ایمیج مپ کنیم )


‍‍‍‍‍

```
user nginx;
worker_processes auto;
error_log /var/log/nginx/error.log;

events {
  worker_connections 1024;
}

http {
  include /etc/nginx/mime.types;
  default_type application/octet-stream;

  access_log /var/log/nginx/access.log;

  sendfile on;
  keepalive_timeout 65;
  server_tokens off;

  gzip on;
  gzip_types text/plain text/css application/javascript application/json application/x-font-ttf image/svg+xml;
  gzip_min_length 1000;

  server {
    listen 80;
    server_name example.com;

    location / {
      proxy_pass http:localhost:3000;
      proxy_set_header Host $host;
      proxy_set_header X-Real-IP $remote_addr;
    }
  }
}
```

از آنجا که هدف درس nginx نبوده تنظیمات آن توضیح نداده ایم

حال دو میکروسرویس next-app و nginx داریم 

</div>
