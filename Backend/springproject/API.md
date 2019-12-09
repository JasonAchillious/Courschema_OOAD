127.0.0.1/home

登录：127.0.0.1/login

学生：127.0.0.1/userhome (param:ID)

学工：127.0.0.1/adminhome (param:ID)

秘书：127.0.0.1/sechome (param:ID)



API:

方法+url+参数+return

ID等默认为integer，API测试时我使用的eolinker上面的raw类型传参数。

全部培养方案

post allchema (no parameter,  return List\<courschema\>)

全部课程

post allcourse (no parameter,  return List\<course\>)

post coursebydepart (departID,  return List\<course\>)

某培养方案中课程

post cla/showClassification (schemaID, return SchemaEdit)

post cla/editClassification (schemaID and SchemaEdit newEdit, return SchemaEdit)

某秘书可管理专业

post showSeMajor (secretaryID, return List\<Major\>)

专业包含培养方案

post schemabyMajor (majorID, return List\<Schema\>)

分年份

post schemabyMajorAndYear (majorID and year, return List\<Schema>)





