FROM openjdk:11
VOLUME /tmp
ENV IMG_PATH= /img
EXPOSE 8080
RUN mkdir -p /img
ADD ./target
 