package mappings

import models.{Camera, Sensor, ValorSensor}
import spray.json.DefaultJsonProtocol

trait JsonMappings extends DefaultJsonProtocol {

  case class SensorValores(sensor: Sensor, valores: List[ValorSensor])

  implicit val valorSensorRespostaFormat = jsonFormat3(ValorSensor)
  implicit val cameraRespostaFormat = jsonFormat3(Camera)
  implicit val sensorRespostaFormat = jsonFormat2(Sensor)
  implicit val sensoresValoresRespostaFormat = jsonFormat2(SensorValores)

}