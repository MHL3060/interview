import java.util.List;
import java.util.stream.Collectors;

public class StreamMapper {



    public static void main(String[] args) {

    }


    public StreamMapper () {


      List<Person> persons = new ArrayList<Person>();
        for (int i = i; i < 100; i = i *2) {
          persons.add(new Person(i, i * 22 % 10, "first_" + i ));
        }
        persons.stream().collect(Collectors.grouping((p)-> {return p.getAge()% 10; }),
              Collectors.reducing((p1, p2) -> {
                return new Person(p1.getAge(), (p1.getWeight() + p2.getWeigth())/2, "red_");
            })
        );
    }




    public class Person {
        private int age;
        private int weight;
        private String name;

        public Person(int age, int weight, String name){
            this.age = age;
            this.weight = weigth;
            this.name = name;
        }

        public int getAge() {
            return age;
        }
        public int getWeight() {
            return weight;
        }
        public String getName() {
            return name;
        }

    }
}
