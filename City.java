import java.util.HashMap;
import java.util.Map;

public class City {
    private String name;
    private Map<City, Integer> routes;

    public City(String name) { //Конструктор создает город с указанным именем
        this.name = name;
        this.routes = new HashMap<>();
    }

    public void setName(String name) { //Сеттер для имени города
        this.name = name;
    }

    //Сеттер для замены карты маршрутов на новую переданную карту
    public void setRoutes(Map<City, Integer> routes) {
        this.routes = routes;
    }

    //Добавляет маршрут из текущего города в указанный город с заданной стоимостью проезда
    public void addRoute(City city, int price) {
        routes.put(city, price);
    }

    public String getName() { //Геттер для имени города
        return name;
    }

    //Геттер возвращает карту всех маршрутов из этого города город - стоимость
    public Map<City, Integer> getRoutes() {
        return routes;
    }

    @Override
    public String toString() { //Метод для создания строки
        StringBuilder res = new StringBuilder();
        res.append(name).append(": ");
        if (routes.isEmpty()) {
            res.append("нет путей");
        } else {
            boolean first = true; //Является ли текущий маршрут первым в списке
            for (Map.Entry<City, Integer> city : routes.entrySet()) {
                if (!first) { //Если это не первый маршрут
                    res.append(", ");  //Добавляем запятую для разделения маршрутов
                }
                res.append(city.getKey().getName()).append("(").append(city.getValue()).
                        append(")");
                first = false; //После первого маршрута устанавливаем afalse
            }
        }
        return res.toString();
    }
}
