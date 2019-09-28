FROM oracle/graalvm-ce:19.2.0.1 as graalvm
COPY . /home/app/create-queue
WORKDIR /home/app/create-queue
RUN gu install native-image
RUN native-image --no-server -cp build/libs/create-queue-*-all.jar \
  --initialize-at-build-time=org.h2.Driver \
 -H:+ReportExceptionStackTraces \
 -H:+TraceClassInitialization \
 -J-Xmx20g \
FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/create-queue .
ENTRYPOINT ["./create-queue"]
