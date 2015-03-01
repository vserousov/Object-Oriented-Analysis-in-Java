/**
 * Класс шара, 1 стандартный шарик 27см в диаметре поднимает всего 3-4 грамма.
 * Шар можно создавать стандартный, а можно самому задавать его диаметр при создании.
 * Шар можно раздувать, надувать и растягивать.
 * Растягивать можно не больше, чем в 2 раза от первоначального размера.
 */
public class Balloon {

    /** Столько грамм поднимает 1 стандартный шар размером в 27см. */
    final static double RAISE_WEIGHT = 4.0;

    /** Столько см диаметра имеет стандартный шар. */
    final static double STANDARD_DIAMETER = 27.0;

    /** Диаметр шара. */
    protected double diameter;

    /** Диаметр шара при создании. */
    protected double diameterBorn;

    /** Прозрачность шара. */
    protected double transparency;

    /**
     * Мутатор для изменения диаметра шара (уровня надутости).
     * Мы можем раздуть шар, уменьшив его диаметр практически до 0.
     * Мы можем растянуть шар не больше чем в 2 раза, иначе он лопнет.
     *
     * @param diameter  Диаметр в см
     * @throws Exception  Если {@code diameter < 0}
     *   или диаметр шара в 2 раза больше его первоначальных размеров
     */
    public void setDiameter(double diameter) throws Exception {
        if (diameter < 0) {
            throw new Exception("Диаметр шара не может быть отрицательным");
        } else if (this.diameterBorn * 2 < diameter) {
            throw new Exception("Мы не можем растянуть шар больше, чем в 2 раза");
        } else {
            this.diameter = diameter;
        }
    }

    /**
     * Аксессор для получения объема шара.
     *
     * @return  Объем шара в м^3
     */
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow((diameter / 2.0) / 100.0, 3);
    }

    /**
     * Аксессор для получения прозрачности шара.
     *
     * @return  Прозрачность шара от 0 до 1
     */
    public double getTransparency() {
        return transparency;
    }

    /**
     * Акссесора для получения веса, который поднимает текущий шар.
     *
     * @return  Вес в кг
     */
    public double getRaiseWeight() {
        return RAISE_WEIGHT * (diameter / STANDARD_DIAMETER) / 1000.0;
    }

    /**
     * Умалчиваемый конструктор создаёт шар со стандартным диаметром.
     */
    public Balloon() {
        this.diameter = STANDARD_DIAMETER;
        this.diameterBorn = this.diameter;
        transparency = Math.random();
    }

    /**
     * Можно создавать шар со своим диаметром.
     *
     * @param diameter  Диаметр в см
     */
    public Balloon(double diameter) {
        this.diameter = diameter;
        this.diameterBorn = this.diameter;
        transparency = Math.random();
    }

}