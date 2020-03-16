@echo off
setlocal enableDelayedExpansion

pushd "\...\PATH_TO_FOLDER\"

for %%f in (*) do (
   set "filename=%%~f"

   for %%A in (A B C D E F G H I J K L M N O P Q R S T U V W X Y Z) do (
      set "filename=!filename:%%A=%%A!"
   )
    ren "%%f" "!filename!" >nul 2>&1
)

for /r "\...\PATH_TO_FOLDER\" %%G in (*.PNG) do ren "%%~G" *.BMP

endlocal