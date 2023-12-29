#Application.properties

Kafka properties:

`pring.kafka.consumer.group-id`- specifies a unique string that identifies the consumer group this consumer belongs to.

`spring.kafka.consumer.auto-offset-reset` property - specifies what to do when there is no initial offset in Kafka or if the current offset does not exist anymore on the server (e.g. because that data has been deleted):
* `earliest`: automatically reset the offset to the earliest offset
* `latest`: automatically reset the offset to the latest offset
* `none`: throw an exception to the consumer if no previous offset is found for the consumer’s group
* `anything else`: throw an exception to the consumer.
* `spring.kafka.consumer.key-deserializer` - specifies the deserializer class for keys.

`spring.kafka.consumer.value-deserializer` - specifies the deserializer class for values.

`spring.kafka.producer.key-deserializer` - specifies the serializer class for keys.

`spring.kafka.producer.value-deserializer` - specifies the serializer class for values.

#Create Kafka Topic

To create a topic on startup, add a bean of type NewTopic. If the topic already exists, the bean is ignored. We will use the topic name "quickstart-events" in this example.

KafkaTopicConfig file.

`https://www.javaguides.net/2022/06/spring-boot-apache-kafka-tutorial.html#google_vignette`