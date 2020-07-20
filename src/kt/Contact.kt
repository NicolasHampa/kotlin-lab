package kt

import java.lang.Exception

fun save(name: String, phone: String, email: String) {
    validateSave(name, phone)
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