'Set objExcel = CreateObject("Excel.Application")
'objExcel.Workbooks.Open("C:\Users\babulalp\Desktop\Macros.xlsm")
'objExcel.Run "updateAccountType", WScript.Arguments.Item(0),WScript.Arguments.Item(1),WScript.Arguments.Item(2)
'objExcel.ActiveWorkbook.Close
'objExcel.Application.Quit


Set objExcel = CreateObject("Excel.Application")
objExcel.Workbooks.Open("C:\Users\babulalp\Desktop\Macros.xlsm")
objExcel.Run "Update", WScript.Arguments.Item(0),WScript.Arguments.Item(1),WScript.Arguments.Item(2)
objExcel.ActiveWorkbook.Close
objExcel.Application.Quit
