client:
  rsc --request --dataMimeType=application/cloudevents+json --route=event \
      --data='{"data": {"nick": "Foo"}, "id": "1", "source": "cloud-event-example", "type": "my.application.Foo", "specversion": "1.0"}' \
      --debug tcp://localhost:7000