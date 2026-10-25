# Java Threading Lab

A set of small Java exercises exploring thread creation, joining, coordination, and collections.

## What is implemented

Thread lifecycle examples, an odd/even printer, a bounded-cache example, and collection utilities.

## Build and run

Use JDK 23 or newer and Maven from the repository root. The Maven file is the source of truth for any lower compiler target.

~~~sh
mvn -B compile
java -cp target/classes Main
~~~

## Scope and limitations

Each main class is a separate exercise. In the existing Main example, join deliberately causes one worker to finish before the other starts. Do not assume every collection helper is safe for concurrent use. For the more complete bounded-queue examples, see java-producer-consumer and java-concurrent-warehouse.

## Verification

See [verification notes](docs/verification.md) for the exact checks performed. A compile result is not an end-to-end test result.

Local configuration, credentials, browser drivers, generated reports, IDE metadata, and personal data are excluded from new source commits. Existing source notices are retained.