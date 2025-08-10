@echo off
echo ============================================
echo  Cleaning compiled output...

if exist out (
    rmdir /s /q out
    echo 'out' folder deleted.
) else (
    echo No 'out' folder found — nothing to delete.
)

echo ============================================
echo  Clean-up complete.
pause
