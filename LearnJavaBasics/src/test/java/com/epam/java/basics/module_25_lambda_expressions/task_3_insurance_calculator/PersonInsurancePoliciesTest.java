package com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.calculator.InsuranceCalculator;
import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.calculator.InsuranceCoefficient;
import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.calculator.PersonInsurancePolicies;
import com.epam.java.basics.module_25_lambda_expressions.task_3_insurance_calculator.insurance.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PersonInsurancePoliciesTest implements InsuranceCalculatorTest<Person> {

    @ParameterizedTest(name = "InsuranceCoefficient for {1} must be {2}")
    @DisplayName("Test for children dependent person insurance")
    @MethodSource
    public void testChildrenDependent(InsuranceCalculator<Person> calculator, Person subject,
                                      InsuranceCoefficient expectedInsurance) {
        testSubject(calculator, subject, expectedInsurance);
    }

    static Stream<Arguments> testChildrenDependent() {
        return InsuranceCalculatorTest.buildFor(
                PersonInsurancePolicies.childrenDependent(5),
                Person::new
        )
                .addNull(InsuranceCoefficient.MIN)
                .add(InsuranceCalculatorTest.emptyConf(), InsuranceCoefficient.MIN)
                .add(p -> p.family(new Family()), InsuranceCoefficient.MIN)
                .add(p -> p.family(
                                new Family().children(
                                        nSizedSet(1, HashSet::new, i -> new Person().name(randomString() + i).surname(randomString())))),
                        InsuranceCoefficient.of(20))
                .add(p -> p.family(
                                new Family().children(
                                        nSizedSet(2, HashSet::new, i -> new Person().name(randomString() + i).surname(randomString())))),
                        InsuranceCoefficient.of(40))
                .add(p -> p.family(
                                new Family().children(
                                        nSizedSet(3, HashSet::new, i -> new Person().name(randomString() + i).surname(randomString())))),
                        InsuranceCoefficient.of(60))
                .add(p -> p.family(
                                new Family().children(
                                        nSizedSet(4, HashSet::new, i -> new Person().name(randomString() + i).surname(randomString())))),
                        InsuranceCoefficient.of(80))
                .add(p -> p.family(
                                new Family().children(
                                        nSizedSet(5, HashSet::new, i -> new Person().name(randomString() + i).surname(randomString())))),
                        InsuranceCoefficient.MAX)
                .add(p -> p.family(
                                new Family().children(
                                        nSizedSet(6, HashSet::new, i -> new Person().name(randomString() + i).surname(randomString())))),
                        InsuranceCoefficient.MAX)
                .build();
    }

    @ParameterizedTest(name = "InsuranceCoefficient for {1} must be {2}")
    @DisplayName("Test for employment dependent person insurance")
    @MethodSource
    public void testEmploymentDependentInsurance(InsuranceCalculator<Person> calculator, Person subject,
                                                 InsuranceCoefficient expectedInsurance) {
        testSubject(calculator, subject, expectedInsurance);
    }

    static Stream<Arguments> testEmploymentDependentInsurance() {
        return InsuranceCalculatorTest.buildFor(
                PersonInsurancePolicies.employmentDependentInsurance(
                        BigInteger.valueOf(5_000),
                        Set.of(Currency.EUR, Currency.GBP)
                ), Person::new)
                .addNull(null)
                .add(InsuranceCalculatorTest.emptyConf(), null)
                .add(p -> p.employmentHistory(nSizedSet(1, TreeSet::new, m -> new Employment()
                        .company(randomString())
                        .startDate(LocalDate.now().minusYears(m + 1))
                        .endDate(LocalDate.now().minusYears(m + 1).plusMonths(1))
                )), null)
                .add(p -> p
                        .employmentHistory(nSizedSet(4, TreeSet::new, m -> new Employment()
                                .company(randomString())
                                .startDate(LocalDate.now().minusYears(m + 1))
                                .endDate(LocalDate.now().minusYears(m + 1).plusMonths(1))
                        ))
                        .account(Map.of(
                                Currency.EUR,
                                BigInteger.ZERO
                        )), null)
                .add(p -> p
                        .employmentHistory(nSizedSet(3, TreeSet::new, m -> new Employment()
                                .company(randomString())
                                .startDate(LocalDate.now().minusYears(m + 1))
                                .endDate(LocalDate.now().minusYears(m + 1).plusMonths(1))
                        ))
                        .account(Map.of(
                                Currency.EUR, BigInteger.ZERO,
                                Currency.USD, BigInteger.ZERO
                        ))
                        .injuries(nSizedSet(1, TreeSet::new, __ -> new Injury()
                                .name(randomString())
                                .date(LocalDate.now())
                        )), null)
                .add(p -> p
                        .employmentHistory(
                                nSizedSet(3, TreeSet::new, m -> new Employment()
                                        .company(randomString())
                                        .startDate(LocalDate.now().minusYears(m + 1))
                                        .endDate(LocalDate.now().minusYears(m + 1).plusMonths(1))
                                )
                        )
                        .account(Map.of(
                                Currency.EUR, BigInteger.ZERO,
                                Currency.USD, BigInteger.ZERO
                        ))
                        .accommodations(nSizedSet(1, TreeSet::new, __ -> new Accommodation()
                                .name(randomString())
                                .area(BigInteger.TEN)
                        )), null)
                .add(p -> p
                        .employmentHistory(
                                nSizedSet(3, TreeSet::new, m -> new Employment()
                                                .company(randomString())
                                                .startDate(LocalDate.now().minusYears(m + 1))
                                                .endDate(LocalDate.now().minusYears(m + 1).plusMonths(1)),
                                        set -> set.add(new Employment()
                                                .company(randomString())
                                                .startDate(LocalDate.now().minusMonths(1))
                                        )
                                )
                        )
                        .account(Map.of(
                                Currency.AUD, BigInteger.ZERO,
                                Currency.USD, BigInteger.ZERO
                        ))
                        .accommodations(nSizedSet(1, TreeSet::new, __ -> new Accommodation()
                                .name(randomString())
                                .area(BigInteger.TEN)
                        )), null)
                .add(p -> p
                        .employmentHistory(
                                nSizedSet(3, TreeSet::new, m -> new Employment()
                                                .company(randomString())
                                                .startDate(LocalDate.now().minusYears(m + 1))
                                                .endDate(LocalDate.now().minusYears(m + 1).plusMonths(1)),
                                        set -> set.add(new Employment()
                                                .company(randomString())
                                                .startDate(LocalDate.now().minusMonths(1))
                                                .salary(new RepeatablePayment(Period.ofMonths(1), Currency.AUD, BigInteger.valueOf(10_000)))
                                        )
                                )
                        )
                        .account(Map.of(
                                Currency.AUD, BigInteger.ZERO,
                                Currency.USD, BigInteger.ZERO
                        ))
                        .accommodations(nSizedSet(1, TreeSet::new, __ -> new Accommodation()
                                .name(randomString())
                                .area(BigInteger.TEN)
                        )), null)
                .add(p -> p
                        .employmentHistory(
                                nSizedSet(3, TreeSet::new, m -> new Employment()
                                                .company(randomString())
                                                .startDate(LocalDate.now().minusYears(m + 1))
                                                .endDate(LocalDate.now().minusYears(m + 1).plusMonths(1)),
                                        set -> set.add(new Employment()
                                                .company(randomString())
                                                .startDate(LocalDate.now().minusMonths(1))
                                                .salary(new RepeatablePayment(Period.ofMonths(1), Currency.EUR, BigInteger.valueOf(1_000)))
                                        )
                                )
                        )
                        .account(Map.of(
                                Currency.AUD, BigInteger.ZERO,
                                Currency.USD, BigInteger.ZERO
                        ))
                        .accommodations(nSizedSet(1, TreeSet::new, __ -> new Accommodation()
                                .name(randomString())
                                .area(BigInteger.TEN)
                        )), null)
                .add(p -> p
                        .employmentHistory(
                                nSizedSet(3, TreeSet::new, m -> new Employment()
                                                .company(randomString())
                                                .startDate(LocalDate.now().minusYears(m + 1))
                                                .endDate(LocalDate.now().minusYears(m + 1).plusMonths(1)),
                                        set -> set.add(new Employment()
                                                .company(randomString())
                                                .startDate(LocalDate.now().minusMonths(1))
                                                .salary(new RepeatablePayment(Period.ofMonths(1), Currency.EUR, BigInteger.valueOf(10_000)))
                                        )
                                )
                        )
                        .account(Map.of(
                                Currency.AUD, BigInteger.ZERO,
                                Currency.USD, BigInteger.ZERO
                        ))
                        .accommodations(nSizedSet(1, TreeSet::new, __ -> new Accommodation()
                                .name(randomString())
                                .area(BigInteger.TEN)
                        )), InsuranceCoefficient.MED)
                .build();
    }

    @ParameterizedTest(name = "InsuranceCoefficient for {1} must be {2}")
    @DisplayName("Test for accommodation emergency dependent person insurance")
    @MethodSource
    public void testAccommodationEmergencyInsurance(InsuranceCalculator<Person> calculator, Person subject,
                                                    InsuranceCoefficient expectedInsurance) {
        testSubject(calculator, subject, expectedInsurance);
    }

    static Stream<Arguments> testAccommodationEmergencyInsurance() {
        Object EmergencyStatus;
        return InsuranceCalculatorTest.buildFor(
                PersonInsurancePolicies.accommodationEmergencyInsurance(Set.of(Accommodation.EmergencyStatus.NONE, Accommodation.EmergencyStatus.LOW)),
                Person::new
        )
                .addNull(null)
                .add(InsuranceCalculatorTest.emptyConf(), null)
                .add(p -> p.accommodations(nSizedSet(1, TreeSet::new, __ -> new Accommodation().area(BigInteger.TEN))), null)
                .add(p -> p.accommodations(nSizedSet(1, TreeSet::new, __ -> new Accommodation()
                        .area(BigInteger.TEN)
                        .emergencyStatus(Accommodation.EmergencyStatus.CRITICAL)
                )), null)
                .add(p -> p.accommodations(nSizedSet(1, TreeSet::new, __ -> new Accommodation()
                        .area(BigInteger.TEN)
                        .emergencyStatus(Accommodation.EmergencyStatus.NONE)
                )), InsuranceCoefficient.MAX)
                .add(p -> p.accommodations(nSizedSet(1, TreeSet::new, __ -> new Accommodation()
                        .area(BigInteger.TEN)
                        .emergencyStatus(Accommodation.EmergencyStatus.LOW)
                )), InsuranceCoefficient.of(80))
                .build();
    }

    @ParameterizedTest(name = "InsuranceCoefficient for {1} must be {2}")
    @DisplayName("Test for injury and rent dependent person insurance")
    @MethodSource
    public void testInjuryAndRentDependentInsurance(InsuranceCalculator<Person> calculator, Person subject,
                                                    InsuranceCoefficient expectedInsurance) {
        testSubject(calculator, subject, expectedInsurance);
    }

    static Stream<Arguments> testInjuryAndRentDependentInsurance() {
        return InsuranceCalculatorTest.buildFor(
                PersonInsurancePolicies.injuryAndRentDependentInsurance(BigInteger.valueOf(1_000)),
                Person::new
        )
                .addNull(null)
                .add(InsuranceCalculatorTest.emptyConf(), null)
                .add(p -> p.injuries(nSizedSet(1, TreeSet::new, __ -> new Injury().date(LocalDate.now()))), null)
                .add(p -> p.injuries(nSizedSet(1, TreeSet::new, __ -> new Injury()
                        .date(LocalDate.now())
                        .culprit(new Person())
                )), null)
                .add(p -> p.injuries(nSizedSet(1, TreeSet::new, __ -> new Injury()
                        .date(LocalDate.now())
                        .culprit(p)
                )), null)
                .add(p -> p
                        .injuries(nSizedSet(1, TreeSet::new, __ -> new Injury()
                                .date(LocalDate.now())
                                .culprit(p)
                        ))
                        .accommodations(nSizedSet(1, TreeSet::new, __ -> new Accommodation()
                                .area(BigInteger.TEN)
                        )), null)
                .add(p -> p
                        .injuries(nSizedSet(1, TreeSet::new, __ -> new Injury()
                                .date(LocalDate.now())
                                .culprit(p)
                        ))
                        .accommodations(nSizedSet(1, TreeSet::new, __ -> new Accommodation()
                                .area(BigInteger.TEN)
                                .rent(new RepeatablePayment(Period.ofMonths(1), Currency.AUD, BigInteger.valueOf(500)))
                        )), null)
                .add(p -> p
                        .injuries(nSizedSet(1, TreeSet::new, __ -> new Injury()
                                .date(LocalDate.now())
                                .culprit(p)
                        ))
                        .accommodations(nSizedSet(1, TreeSet::new, __ -> new Accommodation()
                                .area(BigInteger.TEN)
                                .rent(new RepeatablePayment(Period.ofMonths(1), Currency.GBP, BigInteger.valueOf(500)))
                        )), InsuranceCoefficient.MED)
                .add(p -> p
                        .injuries(nSizedSet(1, TreeSet::new, __ -> new Injury()
                                .date(LocalDate.now())
                                .culprit(p)
                        ))
                        .accommodations(nSizedSet(1, TreeSet::new, __ -> new Accommodation()
                                .area(BigInteger.TEN)
                                .rent(new RepeatablePayment(Period.ofMonths(1), Currency.GBP, BigInteger.valueOf(1_000)))
                        )), InsuranceCoefficient.MAX)
                .add(p -> p
                        .injuries(nSizedSet(1, TreeSet::new, __ -> new Injury()
                                .date(LocalDate.now())
                                .culprit(p)
                        ))
                        .accommodations(nSizedSet(1, TreeSet::new, __ -> new Accommodation()
                                .area(BigInteger.TEN)
                                .rent(new RepeatablePayment(Period.ofMonths(1), Currency.GBP, BigInteger.ZERO))
                        )), InsuranceCoefficient.MIN)
                .build();
    }

    static <T, S extends Set<T>> S nSizedSet(int size, Supplier<S> setGen, IntFunction<T> uniqueGenerator) {
        return nSizedSet(size, setGen, uniqueGenerator, InsuranceCalculatorTest.emptyConf());
    }

    static <T, S extends Set<T>> S nSizedSet(int size, Supplier<S> setGen, IntFunction<T> uniqueGenerator,
                                             Consumer<S> setFinalizer) {
        var set = IntStream.range(0, size)
                .mapToObj(uniqueGenerator)
                .collect(Collectors.toCollection(setGen));
        setFinalizer.accept(set);
        return set;
    }

    private static final Character[] LETTERS = new Character['z' - 'a'];

    static {
        Arrays.setAll(LETTERS, i -> (char) ('a' + i));
    }

    static String randomString() {
        var random = new Random(System.currentTimeMillis());
        return random.ints()
                .limit(16)
                .map(i -> i % LETTERS.length)
                .map(StrictMath::abs)
                .mapToObj(i -> LETTERS[i])
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
