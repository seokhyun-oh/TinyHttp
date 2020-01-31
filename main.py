if __name__ == '__main__':
    http_request_message = "GET /hello.txt HTTP/1.1\r\nUser-Agent: curl/7.16.3 libcurl/7.16.3 OpenSSL/0.9.7l zlib/1.2.3\r\nHost: www.example.com\r\nAccept-Language: en, mi\r\n\r\n\r\n"

    request_line_and_headers, message_body = http_request_message.split('\r\n\r\n')
    request_line, *header_fields = request_line_and_headers.split('\r\n')

    method, request_target, http_version = request_line.split()
    headers = [header.split(': ') for header in header_fields]
