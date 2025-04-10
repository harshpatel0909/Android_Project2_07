package jlin2.examples.localtesting
import org.junit.Assert.*
import org.junit.Test

class EmailValidatorTest {

    @Test fun correctEmail() {
        assertTrue(EmailValidator.isValidEmail("123@abc.com"))
    }

    @Test fun subdomainEmail() {
        assertTrue(EmailValidator.isValidEmail("123@abc.co.ca"))
    }

    @Test fun noDomain() {
        assertFalse(EmailValidator.isValidEmail("123@abc"))
    }

    @Test fun doubleDots() {
        assertFalse(EmailValidator.isValidEmail("123@abc..com"))
    }

//    other cases
}
