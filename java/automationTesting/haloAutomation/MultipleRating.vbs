Set objExcel = CreateObject("Excel.Application")
objExcel.Workbooks.Open("C:\Users\babulalp\workspace\haloAutomation\src\test\resources\data\TableRating.xlsm")
objExcel.Run "TableRating.xlsm!MultipleRating.multipleRating", WScript.Arguments.Item(0),WScript.Arguments.Item(1),WScript.Arguments.Item(2)
objExcel.ActiveWorkbook.Close
objExcel.Application.Quit


