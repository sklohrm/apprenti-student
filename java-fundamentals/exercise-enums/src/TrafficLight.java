public class TrafficLight {
    public static void main(String[] args) {
        //Traffic lights are programmed using an indexed array.

        //1. Create an enum named TrafficLight with values:
        // RED
        //YELLOW
        //GREEN
        // Changed the name of the enum because the class is called TrafficLight already
        enum TrafficLightEnum {
            RED,
            YELLOW,
            GREEN
        }

        //2. Store all values in an array using values().
        TrafficLightEnum[] trafficLightArr = TrafficLightEnum.values();

        //3. Retrieve the correct signal based on a predefined index (1 for YELLOW).
        TrafficLightEnum currentSignal = trafficLightArr[1];

        //4. Print the selected signal.
        System.out.println("Traffic light signal: " + currentSignal);

    }
}
