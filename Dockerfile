FROM mysql:8.4.0

ENV MYSQL_ROOT_PASSWORD=password
ENV TZ=Asia/Seoul

RUN echo "[mysqld]\ndefault-time-zone='Asia/Seoul'" > /etc/mysql/conf.d/timezone.cnf

VOLUME ["/var/lib/mysql"]

EXPOSE 3306
