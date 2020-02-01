class Request:

    def __init__(self, method, request_target, http_version):
        self.method = method
        self.request_target = request_target
        self.http_version = http_version
        self.headers = None
        self.body = None

    @staticmethod
    def of(request_message):
        request_line_and_headers, message_body = request_message.split('\r\n\r\n', maxsplit=1)
        request_line, *header_fields = request_line_and_headers.split('\r\n')
        method, request_target, http_version = request_line.split()

        r = Request(method, request_target, http_version)
        r.headers = [header.split(': ') for header in header_fields]

        return r


if __name__ == '__main__':
    http_request_message = "GET /hello.txt HTTP/1.1\r\nUser-Agent: curl/7.16.3 libcurl/7.16.3 OpenSSL/0.9.7l zlib/1.2.3\r\nHost: www.example.com\r\nAccept-Language: en, mi\r\n\r\n"

    request = Request.of(http_request_message)
