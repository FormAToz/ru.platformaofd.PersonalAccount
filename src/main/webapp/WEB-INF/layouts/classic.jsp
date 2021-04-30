<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<title><tiles:getAsString name="title" /></title>
<style type="text/css">

    .table td, th {
        border: 1px solid black;
        padding: 10px;
        }

    #header, #footer {
        background: #E0E0E0;
        height: 55px;
        padding: 5px;
        text-align: center;
    }

    #footer {
            height: 20px;
        }

</style>
</head>

<body>
    <table width="100%">
        <tr>
            <td colspan="2">
                <tiles:insertAttribute name="header" />
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap">
                 <tiles:insertAttribute name="menu" />
             </td>
            <td width="80%">
                 <tiles:insertAttribute name="body" />
             </td>
        </tr>
        <tr>
            <td colspan="2">
                 <tiles:insertAttribute name="footer" />
            </td>
        </tr>
    </table>
</body>
</html>