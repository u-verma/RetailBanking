package banking.api.customer.convertor

import banking.api.customer.domain.CustomerRequest
import banking.api.customer.domain.CustomerResponse
import banking.api.customer.persitence.entity.AddressEntity
import banking.api.customer.persitence.entity.CustomerEntity
import banking.util.now
import banking.util.toLocalDate
import banking.util.toZoneDateTimeFromMilli

fun CustomerRequest.toCustomerEntity(): CustomerEntity {
    return CustomerEntity(
        firstName = firstName,
        lastName = lastName,
        email = email,
        phone = phone,
        dateOfBirth = dateOfBirth.toLocalDate(),
        addresses = addresses.map { it.toAddressEntity() },
        createdAt = createdAt?.toZoneDateTimeFromMilli() ?: now(),
    )
}

fun CustomerRequest.Address.toAddressEntity() =
    AddressEntity(
        type = type,
        street = street,
        city = city,
        state = state,
        zip = zip,
        country = country,
    )

fun CustomerEntity.toCustomerResponse() = CustomerResponse(
    id = id,
    firstName = firstName,
    lastName = lastName,
    email = email,
)