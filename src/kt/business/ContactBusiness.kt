package kt.business

import kt.entity.Contact
import kt.repository.ContactRepository
import java.lang.Exception

class ContactBusiness {

    fun save(name: String, phone: String, email: String) {
        validateSave(name, phone)

        val contact = Contact(name, phone, email)
        ContactRepository.save(contact)
    }

    fun delete(name: String) {
        validateDelete(name)
    }

    fun validateSave(name: String, phone: String) {
        if (name.isEmpty() || phone.isEmpty()) {
            throw Exception("Name and Phone are required information!")
        }
    }

    fun validateDelete(name: String) {
        if (name.isEmpty()) {
            throw Exception("Please select a contact before removal!")
        }
    }

    fun get(): List<Contact> {
        return ContactRepository.get()
    }

    fun getContactsCount(): String {
        val list = get()

        return when {
            list.isEmpty() -> "0 Contacts"
            list.size == 1 -> "1 Contact"
            else -> "${list.size} Contacts"
        }
    }
}