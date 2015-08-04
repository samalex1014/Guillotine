; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

[Setup]
; NOTE: The value of AppId uniquely identifies this application.
; Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{567D8070-2E5D-4F52-BE0E-A373FB551E94}
AppName=Guillotine
AppVersion=1.0
;AppVerName=Guillotine 1.0
AppPublisher=Smith Tech
DefaultDirName={pf}\Guillotine
DefaultGroupName=Guillotine
AllowNoIcons=yes
OutputBaseFilename=Guillotine Setup
SetupIconFile=C:\Users\Samuel\Google Drive\Documents\Programming\Java\Guillotine\dist\Guillotine (1).ico
Password=fitch1892
Compression=lzma
SolidCompression=yes

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked
Name: "quicklaunchicon"; Description: "{cm:CreateQuickLaunchIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked; OnlyBelowVersion: 0,6.1

[Files]
Source: "C:\Users\Samuel\Google Drive\Documents\Programming\Java\Guillotine\dist\Guillotine.jar"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\Samuel\Google Drive\Documents\Programming\Java\Guillotine\dist\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Icons]
Name: "{group}\Guillotine"; Filename: "{app}\Guillotine.jar"
Name: "{commondesktop}\Guillotine"; Filename: "{app}\Guillotine.jar"; Tasks: desktopicon
Name: "{userappdata}\Microsoft\Internet Explorer\Quick Launch\Guillotine"; Filename: "{app}\Guillotine.jar"; Tasks: quicklaunchicon

[Run]
Filename: "{app}\Guillotine.jar"; Description: "{cm:LaunchProgram,Guillotine}"; Flags: shellexec postinstall skipifsilent
