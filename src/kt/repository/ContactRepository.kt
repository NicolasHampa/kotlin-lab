package kt.repository

import kt.entity.Contact

class ContactRepository {

    companion object {
        private val contactList = mutableListOf<Contact>()

        fun save(contact: Contact) {
            contactList.add(contact)
        }

        fun delete(contact: Contact) {
            var index = 0

            for (item in contactList.withIndex()) {
                if (item.value.name.equals(contact.name) &&
                    item.value.phone.equals(contact.phone) &&
                    item.value.email.equals(contact.email)) {
                    index = item.index
                    break
                }
            }
            contactList.removeAt(index)
        }

        fun get(): List<Contact> {
            return contactList
        }
    }
}