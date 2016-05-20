@ECHO OFF
rem ***********************************************************************
rem Test ID: 0009
rem Template: King
rem Test Function: Lanague   NORWEGIAN
rem ***********************************************************************



:: CREATE VARIABLE %TIMESTAMP%
for /f "tokens=1-8 delims=.:/-, " %%i in ('echo exit^|cmd /q /k"prompt $D $T"') do (
for /f "tokens=2-4 delims=/-,() skip=1" %%a in ('echo.^|date') do (
set dow=%%l
set mm=%%j
set dd=%%k
set yy=%%i
set hh=%%m
set min=%%n
set sec=%%o
set hsec=%%p
)
)


:: ensure that hour is always 2 digits
if %hh%==0 set hh=00
if %hh%==1 set hh=01
if %hh%==2 set hh=02
if %hh%==3 set hh=03
if %hh%==4 set hh=04
if %hh%==5 set hh=05
if %hh%==6 set hh=06
if %hh%==7 set hh=07
if %hh%==8 set hh=08
if %hh%==9 set hh=09


:: assign timeStamp:
:: Add the date and time parameters as necessary - " yy-mm-dd-dow-min-sec-hsec "
set hm=%hh%%min%
set hms=%hh%%min%%sec%



set test=King_Lanague_NORWEGIAN
set hmi_path=/sdcard/%test%_%hms%.png
set local_path=C://Autotest_%timestamp%



:%test%
echo %test%
adb shell "input tap 730 760"
timeout 2
adb shell "input tap 0 0"
timeout 5
adb shell "input tap 0 0"
timeout 0



:screenshot
adb shell "screencap% %hmi_path%"
adb pull %hmi_path% %local_path%

adb shell "input tap Pone4"0 0
timeout 0



@ECHO OFF
rem ***********************************************************************
rem Test ID: 0009
rem Template: King
rem Test Function: Lanague   NORWEGIAN
rem ***********************************************************************



:: CREATE VARIABLE %TIMESTAMP%
for /f "tokens=1-8 delims=.:/-, " %%i in ('echo exit^|cmd /q /k"prompt $D $T"') do (
for /f "tokens=2-4 delims=/-,() skip=1" %%a in ('echo.^|date') do (
set dow=%%l
set mm=%%j
set dd=%%k
set yy=%%i
set hh=%%m
set min=%%n
set sec=%%o
set hsec=%%p
)
)


:: ensure that hour is always 2 digits
if %hh%==0 set hh=00
if %hh%==1 set hh=01
if %hh%==2 set hh=02
if %hh%==3 set hh=03
if %hh%==4 set hh=04
if %hh%==5 set hh=05
if %hh%==6 set hh=06
if %hh%==7 set hh=07
if %hh%==8 set hh=08
if %hh%==9 set hh=09


:: assign timeStamp:
:: Add the date and time parameters as necessary - " yy-mm-dd-dow-min-sec-hsec "
set hm=%hh%%min%
set hms=%hh%%min%%sec%



set test=King_Lanague_NORWEGIAN
set hmi_path=/sdcard/%test%_%hms%.png
set local_path=C://Autotest_%timestamp%



:%test%
echo %test%
adb shell "input tap 730 760"
timeout 2
adb shell "input tap 0 0"
timeout 5
adb shell "input tap 0 0"
timeout 0



:screenshot
adb shell "screencap% %hmi_path%"
adb pull %hmi_path% %local_path%

adb shell "input tap Pone4"0 0
timeout 0



@ECHO OFF
rem ***********************************************************************
rem Test ID: 0009
rem Template: King
rem Test Function: Lanague   NORWEGIAN
rem ***********************************************************************



:: CREATE VARIABLE %TIMESTAMP%
for /f "tokens=1-8 delims=.:/-, " %%i in ('echo exit^|cmd /q /k"prompt $D $T"') do (
for /f "tokens=2-4 delims=/-,() skip=1" %%a in ('echo.^|date') do (
set dow=%%l
set mm=%%j
set dd=%%k
set yy=%%i
set hh=%%m
set min=%%n
set sec=%%o
set hsec=%%p
)
)


:: ensure that hour is always 2 digits
if %hh%==0 set hh=00
if %hh%==1 set hh=01
if %hh%==2 set hh=02
if %hh%==3 set hh=03
if %hh%==4 set hh=04
if %hh%==5 set hh=05
if %hh%==6 set hh=06
if %hh%==7 set hh=07
if %hh%==8 set hh=08
if %hh%==9 set hh=09


:: assign timeStamp:
:: Add the date and time parameters as necessary - " yy-mm-dd-dow-min-sec-hsec "
set hm=%hh%%min%
set hms=%hh%%min%%sec%



set test=King_Lanague_NORWEGIAN
set hmi_path=/sdcard/%test%_%hms%.png
set local_path=C://Autotest_%timestamp%



:%test%
echo %test%
adb shell "input tap 730 760"
timeout 2
adb shell "input tap 0 0"
timeout 5
adb shell "input tap 0 0"
timeout 0



:screenshot
adb shell "screencap% %hmi_path%"
adb pull %hmi_path% %local_path%

adb shell "input tap Pone4"0 0
timeout 0



@ECHO OFF
rem ***********************************************************************
rem Test ID: 0009
rem Template: King
rem Test Function: Lanague   NORWEGIAN
rem ***********************************************************************



:: CREATE VARIABLE %TIMESTAMP%
for /f "tokens=1-8 delims=.:/-, " %%i in ('echo exit^|cmd /q /k"prompt $D $T"') do (
for /f "tokens=2-4 delims=/-,() skip=1" %%a in ('echo.^|date') do (
set dow=%%l
set mm=%%j
set dd=%%k
set yy=%%i
set hh=%%m
set min=%%n
set sec=%%o
set hsec=%%p
)
)


:: ensure that hour is always 2 digits
if %hh%==0 set hh=00
if %hh%==1 set hh=01
if %hh%==2 set hh=02
if %hh%==3 set hh=03
if %hh%==4 set hh=04
if %hh%==5 set hh=05
if %hh%==6 set hh=06
if %hh%==7 set hh=07
if %hh%==8 set hh=08
if %hh%==9 set hh=09


:: assign timeStamp:
:: Add the date and time parameters as necessary - " yy-mm-dd-dow-min-sec-hsec "
set hm=%hh%%min%
set hms=%hh%%min%%sec%



set test=King_Lanague_NORWEGIAN
set hmi_path=/sdcard/%test%_%hms%.png
set local_path=C://Autotest_%timestamp%



:%test%
echo %test%
adb shell "input tap 730 760"
timeout 2
adb shell "input tap 0 0"
timeout 5
adb shell "input tap 0 0"
timeout 0



:screenshot
adb shell "screencap% %hmi_path%"
adb pull %hmi_path% %local_path%

adb shell "input tap Pone4"0 0
timeout 0



@ECHO OFF
rem ***********************************************************************
rem Test ID: 0009
rem Template: King
rem Test Function: Lanague   NORWEGIAN
rem ***********************************************************************



:: CREATE VARIABLE %TIMESTAMP%
for /f "tokens=1-8 delims=.:/-, " %%i in ('echo exit^|cmd /q /k"prompt $D $T"') do (
for /f "tokens=2-4 delims=/-,() skip=1" %%a in ('echo.^|date') do (
set dow=%%l
set mm=%%j
set dd=%%k
set yy=%%i
set hh=%%m
set min=%%n
set sec=%%o
set hsec=%%p
)
)


:: ensure that hour is always 2 digits
if %hh%==0 set hh=00
if %hh%==1 set hh=01
if %hh%==2 set hh=02
if %hh%==3 set hh=03
if %hh%==4 set hh=04
if %hh%==5 set hh=05
if %hh%==6 set hh=06
if %hh%==7 set hh=07
if %hh%==8 set hh=08
if %hh%==9 set hh=09


:: assign timeStamp:
:: Add the date and time parameters as necessary - " yy-mm-dd-dow-min-sec-hsec "
set hm=%hh%%min%
set hms=%hh%%min%%sec%



set test=King_Lanague_NORWEGIAN
set hmi_path=/sdcard/%test%_%hms%.png
set local_path=C://Autotest_%timestamp%



:%test%
echo %test%
adb shell "input tap 730 760"
timeout 2
adb shell "input tap 0 0"
timeout 5
adb shell "input tap 0 0"
timeout 0



:screenshot
adb shell "screencap% %hmi_path%"
adb pull %hmi_path% %local_path%

adb shell "input tap Pone4"0 0
timeout 0



@ECHO OFF
rem ***********************************************************************
rem Test ID: 0009
rem Template: King
rem Test Function: Lanague   NORWEGIAN
rem ***********************************************************************



:: CREATE VARIABLE %TIMESTAMP%
for /f "tokens=1-8 delims=.:/-, " %%i in ('echo exit^|cmd /q /k"prompt $D $T"') do (
for /f "tokens=2-4 delims=/-,() skip=1" %%a in ('echo.^|date') do (
set dow=%%l
set mm=%%j
set dd=%%k
set yy=%%i
set hh=%%m
set min=%%n
set sec=%%o
set hsec=%%p
)
)


:: ensure that hour is always 2 digits
if %hh%==0 set hh=00
if %hh%==1 set hh=01
if %hh%==2 set hh=02
if %hh%==3 set hh=03
if %hh%==4 set hh=04
if %hh%==5 set hh=05
if %hh%==6 set hh=06
if %hh%==7 set hh=07
if %hh%==8 set hh=08
if %hh%==9 set hh=09


:: assign timeStamp:
:: Add the date and time parameters as necessary - " yy-mm-dd-dow-min-sec-hsec "
set hm=%hh%%min%
set hms=%hh%%min%%sec%



set test=King_Lanague_NORWEGIAN
set hmi_path=/sdcard/%test%_%hms%.png
set local_path=C://Autotest_%timestamp%



:%test%
echo %test%
adb shell "input tap 730 760"
timeout 2
adb shell "input tap 0 0"
timeout 5
adb shell "input tap 0 0"
timeout 0



:screenshot
adb shell "screencap% %hmi_path%"
adb pull %hmi_path% %local_path%

adb shell "input tap Pone4"0 0
timeout 0



@ECHO OFF
rem ***********************************************************************
rem Test ID: 0009
rem Template: King
rem Test Function: Lanague   NORWEGIAN
rem ***********************************************************************



:: CREATE VARIABLE %TIMESTAMP%
for /f "tokens=1-8 delims=.:/-, " %%i in ('echo exit^|cmd /q /k"prompt $D $T"') do (
for /f "tokens=2-4 delims=/-,() skip=1" %%a in ('echo.^|date') do (
set dow=%%l
set mm=%%j
set dd=%%k
set yy=%%i
set hh=%%m
set min=%%n
set sec=%%o
set hsec=%%p
)
)


:: ensure that hour is always 2 digits
if %hh%==0 set hh=00
if %hh%==1 set hh=01
if %hh%==2 set hh=02
if %hh%==3 set hh=03
if %hh%==4 set hh=04
if %hh%==5 set hh=05
if %hh%==6 set hh=06
if %hh%==7 set hh=07
if %hh%==8 set hh=08
if %hh%==9 set hh=09


:: assign timeStamp:
:: Add the date and time parameters as necessary - " yy-mm-dd-dow-min-sec-hsec "
set hm=%hh%%min%
set hms=%hh%%min%%sec%



set test=King_Lanague_NORWEGIAN
set hmi_path=/sdcard/%test%_%hms%.png
set local_path=C://Autotest_%timestamp%



:%test%
echo %test%
adb shell "input tap 730 760"
timeout 2
adb shell "input tap 0 0"
timeout 5
adb shell "input tap 0 0"
timeout 0



:screenshot
adb shell "screencap% %hmi_path%"
adb pull %hmi_path% %local_path%

adb shell "input tap Pone4"0 0
timeout 0



@ECHO OFF
rem ***********************************************************************
rem Test ID: 0009
rem Template: King
rem Test Function: Lanague   NORWEGIAN
rem ***********************************************************************



:: CREATE VARIABLE %TIMESTAMP%
for /f "tokens=1-8 delims=.:/-, " %%i in ('echo exit^|cmd /q /k"prompt $D $T"') do (
for /f "tokens=2-4 delims=/-,() skip=1" %%a in ('echo.^|date') do (
set dow=%%l
set mm=%%j
set dd=%%k
set yy=%%i
set hh=%%m
set min=%%n
set sec=%%o
set hsec=%%p
)
)


:: ensure that hour is always 2 digits
if %hh%==0 set hh=00
if %hh%==1 set hh=01
if %hh%==2 set hh=02
if %hh%==3 set hh=03
if %hh%==4 set hh=04
if %hh%==5 set hh=05
if %hh%==6 set hh=06
if %hh%==7 set hh=07
if %hh%==8 set hh=08
if %hh%==9 set hh=09


:: assign timeStamp:
:: Add the date and time parameters as necessary - " yy-mm-dd-dow-min-sec-hsec "
set hm=%hh%%min%
set hms=%hh%%min%%sec%



set test=King_Lanague_NORWEGIAN
set hmi_path=/sdcard/%test%_%hms%.png
set local_path=C://Autotest_%timestamp%



:%test%
echo %test%
adb shell "input tap 730 760"
timeout 2
adb shell "input tap 0 0"
timeout 5
adb shell "input tap 0 0"
timeout 0



:screenshot
adb shell "screencap% %hmi_path%"
adb pull %hmi_path% %local_path%

adb shell "input tap Pone4"0 0
timeout 0



@ECHO OFF
rem ***********************************************************************
rem Test ID: 0009
rem Template: King
rem Test Function: Lanague   NORWEGIAN
rem ***********************************************************************



:: CREATE VARIABLE %TIMESTAMP%
for /f "tokens=1-8 delims=.:/-, " %%i in ('echo exit^|cmd /q /k"prompt $D $T"') do (
for /f "tokens=2-4 delims=/-,() skip=1" %%a in ('echo.^|date') do (
set dow=%%l
set mm=%%j
set dd=%%k
set yy=%%i
set hh=%%m
set min=%%n
set sec=%%o
set hsec=%%p
)
)


:: ensure that hour is always 2 digits
if %hh%==0 set hh=00
if %hh%==1 set hh=01
if %hh%==2 set hh=02
if %hh%==3 set hh=03
if %hh%==4 set hh=04
if %hh%==5 set hh=05
if %hh%==6 set hh=06
if %hh%==7 set hh=07
if %hh%==8 set hh=08
if %hh%==9 set hh=09


:: assign timeStamp:
:: Add the date and time parameters as necessary - " yy-mm-dd-dow-min-sec-hsec "
set hm=%hh%%min%
set hms=%hh%%min%%sec%



set test=King_Lanague_NORWEGIAN
set hmi_path=/sdcard/%test%_%hms%.png
set local_path=C://Autotest_%timestamp%



:%test%
echo %test%
adb shell "input tap 730 760"
timeout 2
adb shell "input tap 0 0"
timeout 5
adb shell "input tap 0 0"
timeout 0



:screenshot
adb shell "screencap% %hmi_path%"
adb pull %hmi_path% %local_path%

adb shell "input tap Pone4"0 0
timeout 0



