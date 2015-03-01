/**
 * Класс дома. У дома можно задать количество этажей, длину и ширину (мутаторы),
 * достать его массу и площадь всех этажей (аксессор).
 * Масса рассчитывается в зависимости от количества этажей и их площади.
 */
public class House {

    /** Вес 1м^2 стены. */
    final static double WALL_WEIGHT = 250.0;

    /** Вес 1м^2 пола\потолка. */
    final static double FLOOR_WEIGHT = 150.0;

    /** Высота этажа. */
    final static double WALL_HEIGHT = 2.5;

    /** Количество этажей. */
    protected int numStoreys;

    /** Длина этажей. */
    protected double length;

    /** Ширина этажей. */
    protected double width;

    /** Количество шариков, прицепленных к дому. */
    protected long numBalloons = 0;

    /** Вес шариков, прицепленных к дому. */
    protected double balloonsWeight = 0.0;

    /**
     * Акссесор для получения полного веса дома.
     * @return  Вес дома
     */
    public double getWeight() {
        // Суммарный вес стен
        double wallsWeight = WALL_WEIGHT * getWallSquare();
        // Суммарный вес пола
        double floorsWeight = FLOOR_WEIGHT * getFloorSquare();
        // Возвращаем суммарный вес дома
        return wallsWeight * numStoreys + floorsWeight * (numStoreys + 1.0);
    }

    /**
     * Аксессор для получения полного веса шаров.
     *
     * @return  Суммарный вес шаров
     */
    public double getBalloonsWeight() {
        return balloonsWeight;
    }

    /**
     * Аксессор для получения количество шаров.
     *
     * @return  Количество шаров
     */
    public long getNumBalloons() {
        return numBalloons;
    }

    /**
     * Аксессор для получения площади стен на одном этаже.
     *
     * @return  Площадь
     */
    public double getWallSquare() {
        // Площадь граничных стен всех этажей
        double borderWallSquare = 2.0 * WALL_HEIGHT * (width + length);
        // Площадь внутренних стен всех этажей
        double insideWallSquare = WALL_HEIGHT * (0.5 * width + length);
        // Возращаем сумму граничных и внутренних стен
        return borderWallSquare + insideWallSquare;
    }

    /**
     * Аксессор для получения площади пола на одном этаже.
     *
     * @return  Площадь
     */
    public double getFloorSquare() {
        // Площадь пола\потолка всех этажей
        return length * width;
    }

    /**
     * Мутатор для изменения количества этажей дома.
     *
     * @param numStoreys  Количество этажей
     * @throws Exception  Если {@code numStoreys < 1}
     */
    public void setNumStoreys(int numStoreys) throws Exception {
        // Выбрасываем исключение, если количество этажей дома не положительно.
        if (numStoreys < 1) {
            throw new Exception("Количество этажей дома должно быть положительным!");
        } else {
            this.numStoreys = numStoreys;
        }
    }

    /**
     * Мутатор для изменения длины этажей дома.
     *
     * @param length  Длина
     * @throws Exception  Если {@code length <= 0}
     */
    public void setLength(double length) throws Exception {
        // Выбрасываем исключение, если длина дома не положительна
        if (length <= 0.0) {
            throw new Exception("Длина этажей дома должна быть положительной!");
        } else {
            this.length = length;
        }
    }

    /**
     * Мутатор для изменения ширины этажей дома.
     *
     * @param width  Ширина
     * @throws Exception  Если {@code width <= 0}
     */
    public void setWidth(double width) throws Exception {
        // Выбрасываем исключение, если ширина дома не положительна
        if (width <= 0.0) {
            throw new Exception("Ширина этажей дома должна быть положительной!");
        } else {
            this.width = width;
        }
    }

    /**
     * Добавляем шарик.
     *
     * @param balloon  Объект шарика
     */
    public void addBalloons(Balloon balloon) {
        // Прибавляем вес шара
        balloonsWeight += balloon.getRaiseWeight();
        // Обновляем количество подцепленных шаров
        numBalloons++;
    }

    /**
     * Добавляем шарик.
     *
     * @param weight  Вес шарика
     */
    public void addBalloons(int weight) {
        // Прибавляем вес шара (переводим в килограммы)
        balloonsWeight += (double)weight / 1000.0;
        // Обновляем количество подцепленных шаров
        numBalloons++;
    }

    /**
     * Удаляем все шарики.
     */
    public void removeBalloons() {
        // Очищаем вес шара
        balloonsWeight = 0.0;
        // Обнуляем количество подцепленных шаров
        numBalloons = 0;
    }

}
