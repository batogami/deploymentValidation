# ecolytiq-deployment-validation

A Java implementation of Instance-Identification for microservices

This library supports the handling of instance-identification fields as proposed in Theos paper. It is based of his golang implementation (https://github.com/theovassiliou/instanceidentification).

In short, via an instance-identification header field, a micro-service instance can disclose its identity by responding with structured information.

A single instance is represented through its MIID

`MIID := <sN> "/" <vN> ["/" <vA>] "%" <t>s`

Example: `msA/1.1/feature-branch-2345abcd%222s`

The complete call-graph including it's own MIID is represented by:

```text
CIID := MIID [ "(" UIDs+ ")"]
UIDs := CIID [ "+" CIID ]+
```

This library provides some helpers to work with this type of instance-identification

```text
CIID := MIID [ "(" UIDs+ ")"]
UIDs := CIID [ "+" CIID ]+
MIID := <sN> "/" <vN> ["/" <vA>] "%" <t>s
```

## Supported functionality

This package supports the

- creation
- parsing
- encoding

of instance-ids


### Parsing of IIds

Giving a CIID with multiple UIDs as input the library will parse it into the leading MIID and a List of CIIDs. This leads into a tree representation of the call graph.