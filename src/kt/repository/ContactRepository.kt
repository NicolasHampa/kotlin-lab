package kt.repository

import kt.entity.Contact

class ContactRepository {

    companion object {
        private val contactList = mutableListOf<Contact>()

        fun save(contact: Contact) {
            contactList.add(contact)
        }

        fun delete(name: String) {

        }
    }
}