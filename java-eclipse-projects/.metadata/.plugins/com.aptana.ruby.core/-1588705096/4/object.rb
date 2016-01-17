class Object < BasicObject
  include Kernel

  ARGF = ARGF
  ARGV = []
  Addrinfo = Addrinfo
  ArgumentError = ArgumentError
  Array = Array
  BasicObject = BasicObject
  BasicSocket = BasicSocket
  Bignum = Bignum
  Binding = Binding
  CGI = CGI
  CROSS_COMPILING = nil
  Class = Class
  Comparable = Comparable
  Complex = Complex
  ConditionVariable = Thread::ConditionVariable
  Config = RbConfig::Obsolete
  Data = Data
  Date = Date
  DateTime = DateTime
  Delegator = Delegator
  Digest = Digest
  Dir = Dir
  ENV = {"XDG_SESSION_PATH"=>"/org/freedesktop/DisplayManager/Session0", "rvm_version"=>"1.25.27 (stable)", "UPSTART_SESSION"=>"unix:abstract=/com/ubuntu/upstart-session/1000/2856", "SESSION_MANAGER"=>"local/funkenn-desktop:@/tmp/.ICE-unix/3060,unix/funkenn-desktop:/tmp/.ICE-unix/3060", "GNOME_DESKTOP_SESSION_ID"=>"this-is-deprecated", "IM_CONFIG_PHASE"=>"1", "GDMSESSION"=>"ubuntu", "COMPIZ_CONFIG_PROFILE"=>"ubuntu", "MANDATORY_PATH"=>"/usr/share/gconf/ubuntu.mandatory.path", "PWD"=>"/home/funkenn/eclipse/jee-mars/eclipse", "SESSIONTYPE"=>"gnome-session", "GIO_LAUNCHED_DESKTOP_FILE_PID"=>"3249", "GTK_IM_MODULE"=>"ibus", "XDG_GREETER_DATA_DIR"=>"/var/lib/lightdm-data/funkenn", "GDK_CORE_DEVICE_EVENTS"=>"1", "MY_RUBY_HOME"=>"/home/funkenn/.rvm/rubies/ruby-2.1.2", "XDG_MENU_PREFIX"=>"gnome-", "TEXTDOMAIN"=>"im-config", "SELINUX_INIT"=>"YES", "_system_type"=>"Linux", "PATH"=>"/home/funkenn/.rvm/gems/ruby-2.1.2/bin:/home/funkenn/.rvm/gems/ruby-2.1.2@global/bin:/home/funkenn/.rvm/rubies/ruby-2.1.2/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/home/funkenn/.rvm/bin:/usr/local/share/npm/bin", "XDG_CURRENT_DESKTOP"=>"Unity", "XDG_CONFIG_DIRS"=>"/etc/xdg/xdg-ubuntu:/usr/share/upstart/xdg:/etc/xdg", "APTANA_VERSION"=>"3.6.0", "LIBOVERLAY_SCROLLBAR"=>"0", "_system_version"=>"14.04", "rvm_path"=>"/home/funkenn/.rvm", "GDM_LANG"=>"en_AU", "XAUTHORITY"=>"/home/funkenn/.Xauthority", "XDG_SEAT"=>"seat0", "XDG_SESSION_ID"=>"c2", "XDG_SEAT_PATH"=>"/org/freedesktop/DisplayManager/Seat0", "XDG_VTNR"=>"7", "GEM_PATH"=>"/home/funkenn/.rvm/gems/ruby-2.1.2:/home/funkenn/.rvm/gems/ruby-2.1.2@global", "GTK_MODULES"=>"overlay-scrollbar:unity-gtk-module", "GNOME_KEYRING_CONTROL"=>"/run/user/1000/keyring-qAQe9Q", "SHLVL"=>"1", "_system_arch"=>"x86_64", "_system_name"=>"Ubuntu", "TEXTDOMAINDIR"=>"/usr/share/locale/", "JOB"=>"dbus", "XDG_DATA_DIRS"=>"/usr/share/ubuntu:/usr/share/gnome:/usr/local/share/:/usr/share/", "QT_QPA_PLATFORMTHEME"=>"appmenu-qt5", "QT_IM_MODULE"=>"ibus", "GIO_LAUNCHED_DESKTOP_FILE"=>"/etc/xdg/autostart/nautilus-autostart.desktop", "rvm_prefix"=>"/home/funkenn", "LOGNAME"=>"funkenn", "IRBRC"=>"/home/funkenn/.rvm/rubies/ruby-2.1.2/.irbrc", "GPG_AGENT_INFO"=>"/run/user/1000/keyring-qAQe9Q/gpg:0:1", "SESSION"=>"ubuntu", "XMODIFIERS"=>"@im=ibus", "SSH_AUTH_SOCK"=>"/run/user/1000/keyring-qAQe9Q/ssh", "DBUS_SESSION_BUS_ADDRESS"=>"unix:abstract=/tmp/dbus-iiHouTCes1", "SHELL"=>"/bin/bash", "rvm_bin_path"=>"/home/funkenn/.rvm/bin", "GNOME_KEYRING_PID"=>"2852", "LANGUAGE"=>"en_AU:en", "GEM_HOME"=>"/home/funkenn/.rvm/gems/ruby-2.1.2", "DESKTOP_SESSION"=>"ubuntu", "INSTANCE"=>"", "DISPLAY"=>":0.0", "CLUTTER_IM_MODULE"=>"xim", "USER"=>"funkenn", "HOME"=>"/home/funkenn", "QT4_IM_MODULE"=>"xim", "DEFAULTS_PATH"=>"/usr/share/gconf/ubuntu.default.path", "XDG_RUNTIME_DIR"=>"/run/user/1000", "LANG"=>"en_AU.UTF-8", "OXYGEN_DISABLE_INNER_SHADOWS_HACK"=>"1"}
  EOFError = EOFError
  Encoding = Encoding
  EncodingError = EncodingError
  Enumerable = Enumerable
  Enumerator = Enumerator
  Errno = Errno
  Etc = Etc
  Exception = Exception
  FALSE = false
  FalseClass = FalseClass
  Fcntl = Fcntl
  Fiber = Fiber
  FiberError = FiberError
  File = File
  FileTest = FileTest
  FileUtils = FileUtils
  Fixnum = Fixnum
  Float = Float
  FloatDomainError = FloatDomainError
  GC = GC
  Gem = Gem
  Hash = Hash
  IO = IO
  IOError = IOError
  IPSocket = IPSocket
  IndexError = IndexError
  Integer = Integer
  Interrupt = Interrupt
  Kernel = Kernel
  KeyError = KeyError
  LoadError = LoadError
  LocalJumpError = LocalJumpError
  Marshal = Marshal
  MatchData = MatchData
  Math = Math
  Method = Method
  Module = Module
  Monitor = Monitor
  MonitorMixin = MonitorMixin
  Mutex = Mutex
  NIL = nil
  NameError = NameError
  Net = Net
  NilClass = NilClass
  NoMemoryError = NoMemoryError
  NoMethodError = NoMethodError
  NotImplementedError = NotImplementedError
  Numeric = Numeric
  OUTPUT_PATH = "/media/funkenn/6588805F4816C45B/Programming/java-eclipse-projects/.metadata/.plugins/com.aptana.ruby.core/-1588705096/4/"
  Object = Object
  ObjectSpace = ObjectSpace
  OpenSSL = OpenSSL
  OptionParser = OptionParser
  Proc = Proc
  Process = Process
  Queue = Thread::Queue
  RUBY_COPYRIGHT = "ruby - Copyright (C) 1993-2014 Yukihiro Matsumoto"
  RUBY_DESCRIPTION = "ruby 2.1.2p95 (2014-05-08 revision 45877) [x86_64-linux]"
  RUBY_ENGINE = "ruby"
  RUBY_PATCHLEVEL = 95
  RUBY_PLATFORM = "x86_64-linux"
  RUBY_RELEASE_DATE = "2014-05-08"
  RUBY_REVISION = 45877
  RUBY_VERSION = "2.1.2"
  Random = Random
  Range = Range
  RangeError = RangeError
  Rational = Rational
  RbConfig = RbConfig
  Regexp = Regexp
  RegexpError = RegexpError
  Resolv = Resolv
  RubyVM = RubyVM
  RuntimeError = RuntimeError
  STDERR = IO.new
  STDIN = IO.new
  STDOUT = IO.new
  ScanError = StringScanner::Error
  ScriptError = ScriptError
  SecureRandom = SecureRandom
  SecurityError = SecurityError
  Signal = Signal
  SignalException = SignalException
  SimpleDelegator = SimpleDelegator
  SizedQueue = Thread::SizedQueue
  Socket = Socket
  SocketError = SocketError
  StandardError = StandardError
  StopIteration = StopIteration
  String = String
  StringIO = StringIO
  StringScanner = StringScanner
  Struct = Struct
  Symbol = Symbol
  SyntaxError = SyntaxError
  SystemCallError = SystemCallError
  SystemExit = SystemExit
  SystemStackError = SystemStackError
  TCPServer = TCPServer
  TCPSocket = TCPSocket
  TOPLEVEL_BINDING = #<Binding:0x000000013a65c8>
  TRUE = true
  TSort = TSort
  Tempfile = Tempfile
  Thread = Thread
  ThreadError = ThreadError
  ThreadGroup = ThreadGroup
  Time = Time
  Timeout = Timeout
  TimeoutError = Timeout::Error
  TracePoint = TracePoint
  TrueClass = TrueClass
  TypeError = TypeError
  UDPSocket = UDPSocket
  UNIXServer = UNIXServer
  UNIXSocket = UNIXSocket
  URI = URI
  UnboundMethod = UnboundMethod
  ZeroDivisionError = ZeroDivisionError
  Zlib = Zlib
  fatal = nil



  protected


  private

  def DelegateClass(arg0)
  end

  def Digest(arg0)
  end

  def dir_names(arg0)
  end

  def file_name(arg0)
  end

  def get_classes
  end

  def grab_instance_method(arg0, arg1)
  end

  def print_args(arg0)
  end

  def print_instance_method(arg0, arg1)
  end

  def print_method(arg0, arg1, arg2, arg3, arg4, *rest)
  end

  def print_type(arg0)
  end

  def print_value(arg0)
  end

  def timeout(arg0, arg1, arg2, *rest)
  end

end
