<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<style>           
.blue-button{
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
	padding:3px 5px;
	color:#fff;
	font-family:'Helvetica Neue',sans-serif;
	font-size:12px;
	border-radius:2px;
	-moz-border-radius:2px;
	-webkit-border-radius:4px;
	border:1px solid #1A87B9
}     
table {
  font-family: "Helvetica Neue", Helvetica, sans-serif;
   width: 50%;
}
th {
  background: SteelBlue;
  color: white;
}
 td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
                padding: 5px 10px;
            }
</style>
</head>
<body>


<h3>Stock List</h3>
<c:if test="${!empty listOfFinance}">
	<table class="tg">
	<tr>
		<th width="80">StockID</th>
		<th width="120">StockName</th>
		<th width="60">View</th>
		</tr>
	<c:forEach items="${listOfFinance}" var="finance">
		<tr>
		    <td>${finance.id}</td>
			<td>${finance.stockid}</td>
			<td>${finance.stockName}</td>
			<td><a href="<c:url value='/getFinance/${finance.id}' />" >Edit</a></td>
	
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
