CREATE TABLE "valor_sensor" (
  "id"      IDENTITY PRIMARY KEY,
  "sensor_id" BIGINT NOT NULL,
  "valor" DOUBLE NOT NULL
);

ALTER TABLE "valor_sensor" ADD FOREIGN KEY ("sensor_id") REFERENCES "sensor" ("id");