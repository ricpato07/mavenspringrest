package com.spring.rest.service;

import com.spring.rest.domain.Person;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service("personService")
public class PersonService {

    protected static Logger logger = Logger.getLogger("service");
    private List<Person> persons = new ArrayList<Person>();

    public PersonService() {
        logger.debug("iniciando database");

        Person person = new Person();
        person.setId(1L);
        person.setFirstName("Juan");
        person.setLastName("Escutia");
        person.setMoney(12.50);

        Person person2 = new Person();
        person2.setId(2L);
        person2.setFirstName("Jose");
        person2.setLastName("Perez");
        person2.setMoney(13.50);

        Person person3 = new Person();
        person3.setId(1L);
        person3.setFirstName("Ernesto");
        person3.setLastName("Guevara");
        person3.setMoney(20.50);

        Person person4 = new Person();
        person4.setId(4L);
        person4.setFirstName("Saul");
        person4.setLastName("Canelo");
        person4.setMoney(102.20);

        persons.add(person);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);

    }

    public List<Person> getAll() {
        logger.debug("Listar las personas");
        return persons;
    }

    public Person get(Long id) {
        logger.debug("Recuperar persona con id: " + id);
        for (Person person : persons) {
            if (person.getId().longValue() == id.longValue()) {
                logger.debug("valor encontrado");
                return person;
            }
        }
        logger.debug("valor no encontrado");
        return null;
    }
    
    public void add(Person person){
        logger.debug("se agregó una persona");
        persons.add(person);
    }
}
