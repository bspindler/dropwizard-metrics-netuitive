# [DropWizard.io](http://www.dropwizard.io/) `netuitive` reporter for sending metrics to Netuitive's Linux agent. 

### add bintray repository 
Go [here ](https://bintray.com/bspindler/netuitive) and click "Set Me Up!" w/help getting the repository setup.

### add `dropwizard-metrics-netuitive` to your pom
```
<dependency>
  <groupId>io.dropwizard.metrics</groupId>
  <artifactId>metrics-netuitive</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```

### add to your dropwizard.io config.yml
```
metrics:
  frequency: 1 minute
  reporters:
      - type: netuitive
        host: localhost
        port: 8125
```

