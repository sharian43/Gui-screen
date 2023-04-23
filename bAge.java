import java.util.Comparator;

class bAge implements Comparator<Person>
    {
        public int compare(Person p1, Person p2)
        {
            return p1.getAge() - p2.getAge();
        }
    }

