import { HttpInterceptorFn } from '@angular/common/http';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const authHeader = 'Basic ' + btoa('jrojas:123456'); 

  const clonedRequest = req.clone({
    setHeaders: {
      Authorization: authHeader
    }
  });

  return next(clonedRequest);
};
