This FIRST Robotics Competition (FRC) Java project contains classes for
3rd party sensors and general robotics support functions not found in the standard
wpilib packages.

# Sensor Support

## ITG-3200 - 3 Axis Gyro (from Team 868)

* Construct Instance
* Use getGyroX(), getGyroY() and/or getGyroZ() methods

```java
private ITG3200 sensor;
private Gyro gyrox;

public void robotInit() {
  sensor = new ITG3200(I2C.Port.kMXP, false);
  // Track angle for duration
  gyrox = sensor.getGyroX();
}

public double getAngle() {
  return gyrox.getAngle();
}

public Gyro createGyroY() {
  // Allocate a new independent gyro tracker on y-axis
  return sensor.getGyroY();
}
```

## BNO055 - NDOF sensor 3 Axis Gyro, Accel, Mag (from Team 2168)

* Use getInstance() method
* Use getGyroX(), getGyroY() and/or getGyroZ() methods

```java
private BNO055 sensor;
private Gyro gyrox;

public void robotInit() {
  sensor = BNO055.getInstance(BNO055.opmode_t.OPERATION_MODE_NDOF,
					          BNO055.vector_type_t.VECTOR_EULER);
  // Track angle for duration
  gyrox = sensor.getGyroX();
}

public double getAngle() {
  return gyrox.getAngle();
}

public Gyro createGyroY() {
  // Allocate a new independent gyro tracker on y-axis
  return sensor.getGyroY();
}
```

