package strategy;

import strategy.pack.Person;

public class Strategy {
    public static void main(String[] args) {
        var person = new Person("98765432111", 18);
        validatePerson(person, new PhysicalPersonValidator());
        validatePerson(person, new Greater18Years());
    }

    public static void validatePerson(Person person, IValidator validator){
        validator.validate(person);
    }

    interface IValidator {
        void validate(Person person);
    }

    private static class PhysicalPersonValidator implements IValidator {
        @Override
        public void validate(Person person) {
            if (person.getRegistry().length() > 11){
                throw new IllegalArgumentException("CPF Invalid!");
            }
        }
    }

    private static class LegalPersonValidator implements IValidator {
        @Override
        public void validate(Person person){
            if (person.getRegistry().length() < 14){
                throw new IllegalArgumentException("CNPJ Invalid!");
            }
        }
    }

    private static class Greater18Years implements IValidator{
        @Override
        public void validate(Person person){
            if (person.getAge() < 18){
                throw new IllegalArgumentException("Under 18 years!");
            }
        }
    }
}
