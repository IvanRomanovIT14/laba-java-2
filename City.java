import java.util.HashMap;
import java.util.Map;

public class City {
    private String name;
    private Map<City, Integer> routes;

    public City(String name) {
        this.name = name;
        this.routes = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoutes(Map<City, Integer> routes) {
        this.routes = routes;
    }

    public void addRoute(City city, int price) {
        routes.put(city, price);
    }

    public String getName() {
        return name;
    }

    public Map<City, Integer> getRoutes() {
        return routes;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(name).append(": ");
        if (routes.isEmpty()) {
            res.append("нет путей");
        } else {
            boolean first = true;
            for (Map.Entry<City, Integer> city : routes.entrySet()) {
                if (!first) {
                    res.append(", ");
                }
                res.append(city.getKey().getName()).append("(").append(city.getValue()).
                        append(")");
                first = false;
            }
        }
        return res.toString();
    }
}