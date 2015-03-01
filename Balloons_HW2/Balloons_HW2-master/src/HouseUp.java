/**
 * Класс поднятия дома, здесь мы создаем дом
 * и генерируем шары, которыми будем поднимать дом.
 */
public class HouseUp {

    /**
     * Точка входа в программу
     * Создаем объект дома, и настраиваем его характеристики
     * на основе аргументов из командной строки
     * К дому прицепляются шарики до тех пор, пока
     * дом не взлетит. Время прицепа шариков фиксируется
     * и затем выводится.
     * Вариант с использованием шара-примитива работает быстрее,
     * чем использование шара-объекта.
     * Сам объект является ссылочным типом + более нагруженным при создании,
     * чем примитив, поэтому и результат медленее, чем у примитива.
     *
     * @param args Аргументы командной строки
     */
    public static void main(String[] args) {
        // Создаём объект дома
        House house = new House();

        // Получаем данные с аргументов командной строки
        int numStoreys = new Integer(args[0]);
        double length = new Double(args[1]);
        double width = new Double(args[2]);

        // Обрабатываем исключения, в случае если входные данные некорректны
        try {
            // Настраиваем параметры дома через мутаторы
            house.setNumStoreys(numStoreys);
            house.setLength(length);
            house.setWidth(width);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Печатаем вес дома
        System.out.println("Вес дома: " + house.getWeight() + " кг");
        System.out.println("Грузоподъемность шариков: 4 г");

        // Фиксируем время перед циклом
        long start = System.currentTimeMillis();

        // Выполняем цикл пока вес, который могут поднимать шарики, не превысит вес дома
        while (house.getWeight() >= house.getBalloonsWeight()) {
            // Добавляем примитив шара
            house.addBalloons(4); // 415 миллисекунд
        }

        // Выясняем, сколько времени выполнялся цикл
        long result = System.currentTimeMillis() - start;

        // Печатаем результаты
        System.out.println("Понадобилось шариков-примитивов для взлёта: " + house.getNumBalloons());
        System.out.println("Время выполнения цикла с примитивами в миллисекундах: " + result);

        // Отцепляем шарики
        house.removeBalloons();

        // Фиксируем время перед циклом
        start = System.currentTimeMillis();

        // Выполняем цикл пока вес, который могут поднимать шарики, не превысит вес дома
        while (house.getWeight() >= house.getBalloonsWeight()) {
            // Добавляем объект шарика
            house.addBalloons(new Balloon());
        }

        // Выясняем, сколько времени выполнялся цикл
        result = System.currentTimeMillis() - start;

        // Печатаем результаты
        System.out.println("Понадобилось шариков-объектов для взлёта: " + house.getNumBalloons());
        System.out.println("Время выполнения цикла с объектами в миллисекундах: " + result);
    }

}
